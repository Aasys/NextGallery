package com.next.gallery.client.application.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.next.gallery.client.server.Cast;
import com.next.gallery.client.server.Catalog;
import com.next.gallery.client.server.Current;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by centos on 8/28/17.
 */
public class HomePanel  extends Composite {

    private static HomePanelUiBinder uiBinder = GWT.create(HomePanelUiBinder.class);

    interface HomePanelUiBinder extends UiBinder<Widget, HomePanel> {
    }

    @UiField
    MaterialNavBrand lblTitle_ui;
    @UiField
    MaterialLabel txtEmail_ui;

    @UiField
    MaterialLink sideConnect;
    @UiField
    MaterialLink sideCatalog;
    @UiField
    MaterialLink sideStar;
    @UiField
    MaterialLink sideLogOut;

    @UiField
    MaterialPanel connectPanel;
    @UiField
    MaterialPanel catalogPanel;
    @UiField
    MaterialPanel playPanel;
    @UiField
    MaterialPanel inPlay;
    @UiField
    MaterialPanel starPanel;

    @UiField
    MaterialCollection connect_collection;

    @UiField
    MaterialCollection catalog_collection;
    @UiField
    MaterialCollection star_collection;

    @UiField
    MaterialCollection related_collection;
    public HomePanel(String email) {
        initWidget(uiBinder.createAndBindUi(this));
        Current.userEmail = email;
        txtEmail_ui.setText(email);
        switchConnect();
    }

    private  void invisible() {
        connectPanel.setVisible(false);
        catalogPanel.setVisible(false);
        playPanel.setVisible(false);
        starPanel.setVisible(false);
    }
    @UiHandler("sideCatalog")
    void onCatalog(ClickEvent e) {
        switchCatalog();
    }
    @UiHandler("sideConnect")
    void onConnect(ClickEvent e) {
        switchConnect();
    }

    @UiHandler("sideStar")
    void onStars(ClickEvent e) {
        switchStars();
    }

    @UiHandler("sideLogOut")
    void onOut(ClickEvent e) {
        Window.Location.reload();
    }

    public void switchConnect() {
        invisible();
        lblTitle_ui.setText("Connect");
        connectPanel.setVisible(true);
        connect_collection.clear();
        if (Current.cast == null) {
            connect_collection.setHeader("Select cast screen...");
        } else {
            connect_collection.setHeader("Connected");
        }
        for (String cast: Cast.cast) {
            MaterialCollectionItem citem = new MaterialCollectionItem();
            MaterialLink link = new MaterialLink(cast);
            MaterialCollectionSecondary csec = new MaterialCollectionSecondary();
            MaterialIcon icon = new MaterialIcon();
            icon.setIconColor(Color.BLUE);
            icon.setIconPosition(IconPosition.RIGHT);
            if (cast.equals(Current.cast)) {
                icon.setIconType(IconType.CAST_CONNECTED);
            } else {
                icon.setIconType(IconType.CAST);
            }
            citem.add(link);
            csec.add(icon);
            citem.add(csec);
            connect_collection.add(citem);

            citem.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent clickEvent) {
                    Current.cast = cast;
                    MaterialToast.fireToast("Connected: "+ cast);
                    switchCatalog();
                }
            });
        }
    }

    public void switchCatalog()
    {
        if (Current.cast == null) {
            MaterialToast.fireToast("Select cast screen first");
            switchConnect();
            return;
        }
        invisible();
        catalogPanel.setVisible(true);
        lblTitle_ui.setText("Media Catalog");
        catalog_collection.clear();
        catalog_collection.setHeader("Select a media to cast");
        List<Integer>  catalog = Catalog.CASTS.get(Current.cast);
        if (catalog == null || catalog.size() == 0) {
            catalog_collection.setHeader("No media available");
        } else {
            for (int x:catalog) {
                Catalog c = Catalog.CATALOGS.get(x);
                MaterialCollectionItem citem = new MaterialCollectionItem();
                citem.setType(CollectionType.AVATAR);
                MaterialImage img = new MaterialImage(c.image, ImageType.CIRCLE);
                MaterialLabel title = new MaterialLabel(c.title);
                title.setFontSize("2em");
                MaterialLabel brief = new MaterialLabel(c.briefDetail);
                citem.add(img);
                citem.add(title);
                citem.add(brief);

                List<Integer> user_star = Catalog.USERS_STARS.get(Current.userEmail);
                if (user_star != null && user_star.contains(x)) {

                    MaterialCollectionSecondary csec = new MaterialCollectionSecondary();
                    MaterialIcon icon = new MaterialIcon(IconType.STAR);
                    icon.setIconColor(Color.YELLOW);
                    icon.setIconPosition(IconPosition.RIGHT);
                    csec.add(icon);

                    citem.add(csec);
                }
                catalog_collection.add(citem);

                citem.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent clickEvent) {
                        MaterialToast.fireToast("Now Showing: "+ c.title);
                        info(x);
                    }
                });
            }
        }
    }

    public void info(int x) {
        invisible();
        playPanel.setVisible(true);
        inPlay.clear();
        related_collection.clear();
        Catalog c = Catalog.CATALOGS.get(x);
        lblTitle_ui.setText("Media Info");
        MaterialLabel title = new MaterialLabel(c.title);
        title.setFontSize("2em");
        MaterialImage img = new MaterialImage(c.image, ImageType.MATERIALBOXED);

        MaterialLabel all = new MaterialLabel(c.description);

        inPlay.add(title);
        inPlay.add(img);
        inPlay.add(all);

        MaterialButton button = new MaterialButton(ButtonType.FLAT);
        button.setBackgroundColor(Color.BLUE);
        button.setIconColor(Color.YELLOW);

        List<Integer> user_star = Catalog.USERS_STARS.get(Current.userEmail);
        if (user_star != null && user_star.contains(x)) {
            button.setIconType(IconType.STAR);
        } else {
            button.setIconType(IconType.STAR_BORDER);
        }
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                List<Integer> user_stars = Catalog.USERS_STARS.get(Current.userEmail);
                if (user_stars != null && user_stars.contains(x)) {
                    user_stars.remove((Object)x);
                    MaterialToast.fireToast("Removed from favorites");
                    button.setIconType(IconType.STAR_BORDER);
                } else {
                    if (user_stars == null) {
                        user_stars = new LinkedList<>();
                        user_stars.add(x);
                        Catalog.USERS_STARS.put(Current.userEmail, user_stars);
                    } else {
                        user_stars.add(x);
                    }
                    MaterialToast.fireToast("Added to favorites");
                    button.setIconType(IconType.STAR);
                }
            }
        });
        inPlay.add(button);
        if (c.relater != null && c.relater.size()>0) {
            related_collection.setHeader("Related items");
            for (int y:c.relater) {
                Catalog cx = Catalog.CATALOGS.get(y);
                MaterialCollectionItem citem = new MaterialCollectionItem();
                citem.setType(CollectionType.AVATAR);
                MaterialImage img2 = new MaterialImage(cx.image, ImageType.CIRCLE);
                MaterialLabel title2 = new MaterialLabel(cx.title);
                title.setFontSize("2em");
                MaterialLabel brief2 = new MaterialLabel(cx.briefDetail);
                citem.add(img2);
                citem.add(title2);
                citem.add(brief2);
                 if (user_star != null && user_star.contains(y)) {

                    MaterialCollectionSecondary csec = new MaterialCollectionSecondary();
                    MaterialIcon icon = new MaterialIcon(IconType.STAR);
                    icon.setIconColor(Color.YELLOW);
                    icon.setIconPosition(IconPosition.RIGHT);
                    csec.add(icon);

                    citem.add(csec);
                }
                related_collection.add(citem);

                citem.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent clickEvent) {
                        info(y);
                    }
                });
            }
        } else {

            related_collection.setHeader("No related items.");
        }

    }


    public void switchStars()
    {
        invisible();
        starPanel.setVisible(true);
        lblTitle_ui.setText("Favorites");
        star_collection.clear();
        star_collection.setHeader("Select to get more information");
        List<Integer>  catalog = Catalog.USERS_STARS.get(Current.userEmail);
        if (catalog == null || catalog.size() == 0) {
            star_collection.setHeader("No favorite items");
        } else {
            for (int x:catalog) {
                Catalog c = Catalog.CATALOGS.get(x);
                MaterialCollectionItem citem = new MaterialCollectionItem();
                citem.setType(CollectionType.AVATAR);
                MaterialImage img = new MaterialImage(c.image, ImageType.CIRCLE);
                MaterialLabel title = new MaterialLabel(c.title);
                title.setFontSize("2em");
                MaterialLabel brief = new MaterialLabel(c.briefDetail);
                citem.add(img);
                citem.add(title);
                citem.add(brief);

                MaterialCollectionSecondary csec = new MaterialCollectionSecondary();
                MaterialIcon icon = new MaterialIcon(IconType.STAR);
                icon.setIconColor(Color.YELLOW);
                icon.setIconPosition(IconPosition.RIGHT);
                csec.add(icon);

                citem.add(csec);
                star_collection.add(citem);

                citem.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent clickEvent) {
                        info(x);
                    }
                });
            }
        }
    }


}
