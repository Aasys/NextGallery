package com.next.gallery.client.server;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by centos on 8/28/17.
 */
public class Catalog {
    public String title;
    public String image;
    public String briefDetail;
    public String description;
    public List<Integer> relater = new LinkedList<>();

    public Catalog(String title, String image, String briefDetail, String description) {
        this.title = title;
        this.image = image;
        this.briefDetail = briefDetail;
        this.description = description;
    }

    public static Map<Integer,Catalog> CATALOGS= new HashMap<>();
    public static Map<String, List<Integer>> CASTS= new HashMap<>();
    public  static Map<String, List<Integer>> USERS_STARS = new HashMap<>();


    static {
        Catalog c = new Catalog("Majungasaurus",
               "https://www.newdinosaurs.com/wp-content/uploads/2016/01/260_majungasaurus_daniel_eskridge.jpg",
                " bipedal predator that had small hands and a short snout with thickened bone",
                "Majungasaurus is a dinosaur which lived approximately 70 million years ago during the Cretaceous Period. It was first discovered in 1896 by a French army officer along the Betsiboka River in Madagascar. It was then named Majungasaurus, a name which means “Majungha Lizard.”\n" +
                        "\n" +
                        "This dinosaur was approximately 20 feet long and weighed around a ton. It was a bipedal predator that had small hands and a short snout with thickened bone on it. It also had a single small horn on top of its skull. It is known that this dinosaur was a carnivore and may have hunted many different types of dinosaurs at the same. It may have even hunted its own kind as has been shown by the fossil record. Fossils of this dinosaur have been found bearing the teeth of other Majungasaurus dinosaurs. This is the only direct evidence of cannibalism that has ever been attributed with direct evidence to a dinosaur species. Although to be fair, it may just have scavenged the already dead remains of other Majungasaurus.\n" +
                        "\n" +
                        "An interesting fact about this dinosaur is that due to the pro ponderous of skeletal material, this dinosaur is currently one of the most studied dinosaurs of all time. It is believed to have been the apex predator of its ecosystem.");
        c.relater.add(3);
        CATALOGS.put(1, c);

        c = new Catalog("Sauroposeidon",
                "https://www.newdinosaurs.com/wp-content/uploads/2016/01/253_sauroposeidon_alexander.jpg",
                "This dinosaur was 100 feet long, 60 feet high and weighed in excess of 60 tons.",
                "Sauroposeidon is a dinosaur which lived approximately 110 million years ago during the Cretaceous Period. It was first discovered in 1994 along the Oklahoma and Texas border by Dr. Richard Cifelli and his team from the Oklahoma Museum of Natural History. It was named “earthquake god lizard” because it was believed that when this dinosaur walked the whole Earth shook due to its size.\n" +
                        "\n" +
                        "This dinosaur was 100 feet long, 60 feet high and weighed in excess of 60 tons. Its neck was about a third longer than that of its closest relative—Brachiosaurus. Its neck was so large, its individual vertebrae were over 4 feet long and looked more like the trunks of trees than spinal bones.\n" +
                        "\n" +
                        "Sauroposeidon was an herbivore that probably lived off of leaves and other plant material. However, it must have required a whole lot of plant material to keep this massive dinosaur alive. It probably feasted on tons of conifers and early flowering trees.\n" +
                        "\n" +
                        "It is also believed that there wouldn’t have been any predators big enough to have been able to take down a full size Sauroposeidon. It is believed that once these dinosaurs reached maturity, then they would have been virtually safe from all attacks from carnivores.\n" +
                        "\n" +
                        "An interesting fact to note about this dinosaur is that there is some debate whether or not whether they could raise their heads up to eat the tops of trees. Some paleontologists say that it would be virtually impossible for this dinosaur to raise its head up because it would have put an enormous strain on its heart. Therefore, these paleontologists postulate that this dinosaur must have swung its head back and forth and used it like a vacuum to suck up plant material from the forest floor.");
        c.relater.add(4);
        CATALOGS.put(2, c);

        c =  new Catalog("Edmontosaurus",
                "https://www.newdinosaurs.com/wp-content/uploads/2016/01/248_edmontosaurus_martin_garratt.jpg",
                "Edmontosaurus is a duck billed dinosaur which lived approximately 66 to 74 million years ago",
                "Edmontosaurus is a duck billed dinosaur which lived approximately 66 to 74 million years ago during the Cretaceous Period. It was first discovered in 1871 in Alberta, Canada—although that fossil was more than likely named Trachodon cavatus by Edward Cope. However, these bones have since been lost. Officially, the bones of this species were named Edmontosaurus in 1917 by Lawrence Lambe. Its name literally means “Edmonton Lizard.”\n" +
                        "\n" +
                        "Edmontosaurus was a fairly large dinosaur. It was approximately 42 feet long, 10 feet high at the hips and probably weighed around 3 to 4 tons. It is believed to have been an herbivore and probably lived off plant material such as ginkgos, conifers and cycads. It had a toothless beak which would have been perfect for crushing this sort of plant material.\n" +
                        "\n" +
                        "Since its initial discovery, this dinosaur has been found all over North America. This suggests that these dinosaurs were probably nomadic and may have even traveled in large herds for protection from the apex predators of their day.\n" +
                        "\n" +
                        "An interesting fact about Edmontosaurus is that is may have had loose skin around its fact that it could blow up like a balloon. It might have done this to attract a mate or to ward off other males in intraspecies contests that likely arose between competing males. It may have even used it to ward off predators, although this is probably the least likely scenario for this skin flap’s purpose.");
        c.relater.add(1);
        c.relater.add(2);
        CATALOGS.put(3, c);

        c = new Catalog("Deinocheirus",
                "https://www.newdinosaurs.com/wp-content/uploads/2016/01/242_deinocheirus_sameerprehistorica.jpg",
                "Deinocheirus was around 30 feet long, almost 15 feet high and weighed about 6 tons. ",
                "Deinocheirus was one of the most mysterious dinosaurs to have ever been found by paleontologists. It was originally found in 1965 in Southern Mongolia—actually, not the whole dinosaur was found but only its gigantic hands. And for the next 50 years, that is all that scientists would have of this elusive dinosaur. That is probably why its name means “terrible hand”.\n" +
                        "\n" +
                        "That changed in 2012, when 3 paleontologists—Phil Bell, Yuong- Nam Lee and Philip J. Currie—discovered 2 new specimens that would reveal all of the secrets that this dinosaur once held. Secrets of its size and what it is believed to have eaten. Up until that point, the only thing that was really known about this dinosaur was that it had massive hands and lived about 70 million years ago during the late Cretaceous Period.\n" +
                        "\n" +
                        "Deinocheirus was around 30 feet long, almost 15 feet high and weighed about 6 tons. It was a bipedal dinosaur—from a species called Ornithomimids, which are sometimes called ‘ostrich dinosaurs’ and was the biggest of these dinosaurs. However, it probably didn’t move like an ostrich. Due to its large size and weight, it more than likely lumbered along and didn’t run very quickly. I\n" +
                        "\n" +
                        "It is believed that this dinosaur was a scavenger of sorts. It is believed to have eaten a variety of different things such as fish, invertebrates, plants and maybe even insects. It probably didn’t hunt prey like a predator. However, an interesting fact about this dinosaur is that it was probably frequently hunted by tyrannosaurus dinosaurs, as bite marks on its skeleton would suggest.");
        c.relater.add(2);
        c.relater.add(3);
        CATALOGS.put(4 , c);

        c = new Catalog("Red Knee Tarantula",
                "https://a-z-animals.com/media/animals/images/470x370/red_knee_tarantula.jpg",
                "Scientific Name:\tBrachypelma Smithi",
                "The red knee tarantula (also known as the red-kneed tarantula) is a type of burrowing tarantula that inhabits the pacific mountains of Mexico. The red knee tarantula is most well known for it's hairy body and the red bands that are along it's legs.\n" +
                        "The red knee tarantula inhabits the complex scrub-forest habitat and semi-desert regions where there is an abundance of food. The red knee tarantula needs to burrow and so is rarely found on rock faces.\n" +
                        "\n" +
                        "The Red Knee tarantula is found in Mexico, south-western United States and Panama. They are quite common now to be kept as pets as they are slow growers and they have a beautiful body in colour and shape. The red knee tarantula also has a bite that could hurt a human but would not be harmful.\n" +
                        "\n" +
                        "The red knee tarantula typically grows to around 20cm in length but some red knee tarantula individuals have known to become much bigger. The red knee tarantula has a relatively long lifespan for a spider as many get to be older than 30 years of age.");
        c.relater.add(6);
        c.relater.add(7);
        CATALOGS.put(5, c);

        c = new Catalog("Snowy Owl",
                "https://a-z-animals.com/media/animals/images/470x370/snowy_owl.jpg",
                "The snowy owl is one of the largest species of owl in the world,",
                "The snowy owl is also known as the Arctic owl or the great white owl. The snowy owl is primarily found within the Arctic Circle with the range of the snowy owl ranging across Canada, Greenland, Europe and Asia. The snowy owl is the official bird of Quebec in the North-east of Canada.\n" +
                        "The snowy owl is one of the largest species of owl in the world, with the average adult snowy owl growing to about 65cm tall with a wingspan of around 140cm. Snowy owls however can be smaller than this, and can even grow to more than 75cm in height.\n" +
                        "\n" +
                        "Despite the vast range of the snowy owl within the Arctic Circle, it has been reported for snowy owls to travel further south in search of food. Snowy owls have been spotted as far south as Texas in the USA and even in the Caribbean. Snowy owls are also commonly spotted throughout Europe and Asia, from the UK to the southern China.\n" +
                        "\n" +
                        "Snowy owls make their nests on the ground but they chose their nesting place very carefully. A nest site for the snowy owl must have good visibility so that the snowy owl is able to keep and eye on it's surroundings, and the nest of the snowy owl must also have a good source of food so that the snowy owl does not have leave the nest for long (if at all) in order to eat.");
        c.relater.add(5);
        c.relater.add(7);
        CATALOGS.put(6, c);

        c = new Catalog("Snapping Turtle",
                "https://a-z-animals.com/media/animals/images/470x370/snapping_turtle7.jpg",
                "Snapping turtles do not make good pets, usually, as they will never stop growing. ",
                "Snapping turtles are large aquatic freshwater reptiles that only live in North America. There are only two species of snapping turtle that still exist, which are the Common Snapping Turtle and the Alligator Snapping Turtle. The Common Snapping Turtle tends to live at higher latitudes than the Alligator.\n" +
                        "Snapping turtles enjoy a wide variety of food and are often considered the top predator in their environment. The alligator snapping turtle's diet consists mainly of fish, which they lure using a pink worm-like appendage on the end of their tongue. Common snapping turtles are more active hunters and will eat just about anything.\n" +
                        "\n" +
                        "Snapping turtles do not make good pets, usually, as they will never stop growing. The largest snapping turtles on record have weight records of around 600 lbs. Alligator snapping turtles have been known to grow even larger.\n" +
                        "\n" +
                        "The Snapping turtle's main defence mechanism is their powerful snapping jaws, which enable them to make short work of attackers and small prey. They also have monstrous, thick claws on their front and back legs which they use to tear apart food and to climb hills each year where they lay their eggs (in a similar way to sea turtles).\n" +
                        "\n" +
                        "The alligator snapping turtle is the largest freshwater turtle in North America, where it is generally found in the more southern waters of the United States. The smaller and more aggressive common snapping turtle inhabits lakes and streams from South America to Canada.");
        c.relater.add(5);
        c.relater.add(6);
        CATALOGS.put(7 , c);


        /////////////////

        List<Integer> intList = new LinkedList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        CASTS.put("Outside-Dinos-cast", intList);
        intList = new LinkedList<>();
        intList.add(5);
        intList.add(6);
        intList.add(7);
        CASTS.put("East-Wing-cast", intList);
        intList = new LinkedList<>();
        intList.add(1);
        intList.add(4);
        intList.add(6);
        USERS_STARS.put("ng@aasys.com", intList);
    }


}
