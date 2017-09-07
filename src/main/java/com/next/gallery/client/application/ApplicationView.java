/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.next.gallery.client.application;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.next.gallery.client.application.panels.HomePanel;
import com.next.gallery.client.server.User;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;

public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField
    MaterialTextBox txtEmail_ui;
    @UiField
    MaterialTextBox txtPassword_ui;
    @UiField
    MaterialButton btnLogIn_ui;
    @UiField
    MaterialButton btnRegister_ui;

    @Inject
    ApplicationView(
            Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        txtEmail_ui.addKeyDownHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent keyDownEvent) {
                checkEmail();
            }
        });
        txtPassword_ui.addKeyDownHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent keyDownEvent) {
                checkPassword();
            }
        });
    }

    private  boolean checkEmail() {
        if (txtEmail_ui.getText().contains("@") && !txtEmail_ui.getText().endsWith("@") && txtEmail_ui.getText().contains(".")) {
            txtEmail_ui.setSuccess("");
            return true;
        } else {
            txtEmail_ui.setError("Invalid email");
            return false;
        }
    }

    private  boolean checkPassword() {
        if (txtPassword_ui.getText().length() >= 4) {
            txtPassword_ui.setSuccess("");
            return true;
        } else {
            txtPassword_ui.setError("Invalid Password");
            return false;
        }
    }

    @UiHandler("btnLogIn_ui")
    void onLogin(ClickEvent e) {
//        RootPanel.get().clear();
//        RootPanel.get().add(new HomePanel("ng@aasys.com"));
        if (checkEmail() && checkPassword()) {
            boolean r = User.login(txtEmail_ui.getText(), txtPassword_ui.getText());
            if (r) {
                RootPanel.get().clear();
                RootPanel.get().add(new HomePanel(txtEmail_ui.getText()));
            } else {
                MaterialToast.fireToast("email and/or password incorrect");
            }
        } else {
            MaterialToast.fireToast("Check email and/or password");
        }
    }

    @UiHandler("btnRegister_ui")
    void onRegister(ClickEvent e) {
        if (checkEmail() && checkPassword()) {
            boolean r = User.register(txtEmail_ui.getText(), txtPassword_ui.getText());
            if (r) {
                RootPanel.get().clear();
                RootPanel.get().add(new HomePanel(txtEmail_ui.getText()));
            } else {
                MaterialToast.fireToast("email already exist");
            }
        } else {
            MaterialToast.fireToast("Check email and/or password");
        }
    }


}
