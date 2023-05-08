package com.grimschitz.mankomania.BoardLogic;

import com.grimschitz.mankomania.FieldLogic.Field;

public class BoardFields {
    private static Field[] fields;
    private BoardFields() {}

    public Field[] getFields(){
        fields = initFields();
        connectFields(fields);
        return fields;
    }

    private static Field[] initFields(){
        return new Field[]{
                new Field(0, "Dein Buch \"Geld verjubeln leicht gemacht\" ist ein Bestseller! Kassiere 5000 Euro"),
                new Field(1, "Verwoehne dich beim Juwelier \"Bling Bling & Bling\". Zahle 170.000 Euro."),
                new Field(2, "Goenne dir eine goldene Handyhuelle. Zahle 50.000 Euro."),
                new Field(3, "Deine Brieftasche ist zu schwer! Zahle 100.000"),
                new Field(4, "Brandstiftung ist teuer! Zahle 50.000"),
                new Field(5, "Du bist der ein millionste Kunden bei \"Edel und Teuer\". Du gewinnst 10000 Euro."),
                new Field(6, "Du kaufst ersatzteile fuer deinen Opel Corsa. Zahle 100.000 Euro."),
                new Field(7, "Du kaufst Lottoscheine - kein Gewinn. Zahle 50.000 Euro"),
                new Field(8, "Heute wieder blau machen, tu nix."),
                new Field(9, "Mit deinem Bild \"Malen nach Zahlen\" gewinnst du den Turner Prize. Kassiere 10.000 Euro"),
                new Field(10, "Du klaust das Zuhause eines Bettlers. Du erhaelst 50 Euro."),
                new Field(11, "Alles Gute zum Geburtstag! Du erhaelst 5.000 Euro"),
                new Field(12, "Polizei sprengt deinen Drogenring. Zahle 100.000 Euro Kaution."),
                new Field(13, "Du kaufst Brieflose ohne Gewinn. Zahle 50.000 Euro"),
                new Field(14, "Du kaufst nutzlose antike Gegenstaende. Zahle 50.000 Euro."),
                new Field(15, "Zu viel trainiert. Gehe zum Osteopathen. Zahle 50.000 Euro."),
                new Field(16, "Du klaust meine Unterhose. Du erhaelst 50 Euro."),
                new Field(17, "Deine Eltern haben Hochzeitstag! Ueberrasche Sie mit einer VIP-Weltreise. Zahle 100.000 Euro"),
                new Field(18, "Du kaufst Lotterielose ohne Gewinn. Zahle 50.000 Euro"),
                new Field(19, "Exklusive Fotoshooting fuer ein Cosplaymagazin Kassiere 50.000 Euro."),
                new Field(20, "Du klaust den Schuh eines Bettlers. Du erhaelst 50 Euro."),
                new Field(21, "Du kaufst einen Biber. Zahle 50.000 Euro."),
                new Field(22, "Titel gewonnen! \"Begossenster Pudel des Jahres\" bei der World Dog Show. Kassiere 10.000 Euro"),
                // MINIGAME BÖRSE
                new Field(23, "Börse"),
                new Field(24, "Du kaufst zwei Biber. Zahle 100.000 Euro"),
                new Field(25, "Poledance ist schmerzhaft! Gehe zum Osteopathen. Zahle 50.000 Euro."),
                new Field(26, "Hamsterkauf! Besorge einen Jahresvorrat Klopapier aus 4 lagiger Seide. Zahle 40.000 Euro."),
                new Field(27, "Der Mitgliedsbeitrag fuer den Golfclub ist faellig. Zahle 50.000 Euro."),
                new Field(28, "Beauftragte Saylor Twift damit, dir einen Klingelton zu komponieren. Zahle 70.000 Euro"),
                new Field(29, "Razzia bei dir! Zahle 50.000 Euro."),
                new Field(30, "Heute haste frei"),
                new Field(31, "Kaufe eine Discokugel aus Diamanten. Zahle 150.000 Euro"),
                new Field(32, "Du klaust den Hut eines Bettlers. Du erhaelst 50 Euro."),
                new Field(33, "Verwoehne dich in einem obszoenen Etablissement. Zahle 30.000 Euro"),
                new Field(34, "Nix zu tun"),
                new Field(35, "Verwoehne deinen Hund mit einem Halsband aus Rubinen. Zahle 30.000 Euro"),
                new Field(36, "Du bist auf einem Hamster ausgerutscht. Kassiere 10.000 Euro"),
                new Field(37, "Du klaust den Hut eines Bettlers. Du erhaelst 50 Euro."),
                new Field(38, "Spendierhosen in der Bar! Zahle 5.000 Euro"),
                new Field(39, "Kaufe Anteile an einem Rennpferd! Zahle 50.000 Euro."),
                new Field(40, "Kaufe Anteile an nachhaltigen Kohlebergwerken! Zahle 70.000 Euro."),
                new Field(41, "Du verletzt dich bei einem Wrestlingmatch! Du erhaelst 200.000 Euro."),
                // MINIGAME AUKTIONSHAUS
                new Field(42, "Auktionshaus"),
                new Field(43, "Deine Oma benoetigt ein neues Facelifting. Zahle 80.000 Euro"),
                new Field(44, "Du verkaufst die Uni Klagenfurt. Du erhaelst 250 Euro."),
                new Field(45, "Du klaust Kinder. Du erhaelst 50 Euro."),
                new Field(46, "Du steckst deine Ersparnisse in Bitcoin. Zahle 100.000 Euro."),
                new Field(47, "Heute ist nicht dein Tag! Zahle 100.000 Euro."),
                new Field(48, "Du steckst deine Ersparnisse in Bitcoin. Zahle 100.000 Euro."),
                new Field(49, "Du steckst deine Ersparnisse in Etherium. Zahle 100.000 Euro."),
                new Field(50, "Du steckst deine Ersparnisse in DogeCoin. Zahle 100.000 Euro."),
                new Field(51, "Du steckst deine Ersparnisse in NFTs. Zahle 100.000 Euro."),
                new Field(52, "Du steckst deine Ersparnisse in ein Schneeballsystem. Zahle 100.000 Euro."),
                new Field(53, "Deine Mutter klaut dein Geld fuer eine neue Handtasche. Zahle 200.000 Euro."),
                new Field(54, "Verwoehne deine Hausratte mit Socken aus Kaschmir! Zahle 40.000 Euro."),
                new Field(55, "Du verkaufst deine Kinder. Bekomme 70.000 Euro."),
                // MINIGAME RENNSTRECKE
                new Field(56, "Nix zu tun"),
                new Field(57, "Du bist auf einem Kaviarschnittchen ausgerutscht. Kassiere 10.000 Euro"),
                new Field(58, "Goenn dir einen mit Champagner gefuellten Jacuzzi. Zahle 60.000 Euro."),
                new Field(59, "Goenn dir eine Schoenheits-OP (welche du unbedingt benoetigst). Zahle 60.000 Euro."),
                new Field(60, "Du klaust den Hut eines Mitspielers. Du erhaelst 50 Euro."),
                new Field(61, "Du kaufst Mankomania. Zahle 100.000 Euro."),
                new Field(62, "Spendiere einem Spieler deiner Wahl eine Verjuengerungskur Zahle 100.000 Euro."),
                new Field(63, "Du versenkst deine Yacht im Woerthersee. Zahle 200.000 Euro."),
                new Field(64, "Verwoehne dein Pony mit Beinwaermern aus Kaschmir! Zahle 50.000 Euro."),
                new Field(65, "Kaufe Kinder. Zahle 50.000 Euro."),
                new Field(66, "Heute ist das Leben nicht nett zu dir! Zahle 10.000 Euro."),
                new Field(67, "Dein Hamster stirbt und die Nagetierversicherung zahlt. Kassiere 10.000 Euro"),
                new Field(68, "Du kaufst einen Spieler deiner Wahl. Zahle 100.000 Euro.")
        };
    }



    private static void connectFields(Field[] fields) {
        fields[0].setNextField(fields[4]);
        fields[0].setPreviousField(fields[68]);
        fields[1].setNextField(fields[21]);
        fields[1].setPreviousField(fields[20]);
        fields[2].setNextField(fields[36]);
        fields[2].setPreviousField(fields[35]);
        fields[3].setNextField(fields[54]);
        fields[3].setPreviousField(fields[53]);
        for (int i = 4; i < fields.length; i++) {
            switch (i) {
                case 4: // Start Position 1
                    fields[i].setNextField(fields[i + 1]);
                    fields[i].setPreviousField(fields[0]);
                    break;
                case 8: // Intersection 1 First 1
                    fields[i].setNextField(fields[12]);
                    fields[i].setPreviousField(fields[i - 1]);
                    break;
                case 9:
                case 10:
                case 41:
                case 42: // Intersection Fields
                    fields[i].setNextField(fields[i - 1]);
                    fields[i].setPreviousField(fields[i + 1]);
                    break;
                case 11: // Intersection 1 First 1
                    fields[i].setNextField(fields[i - 1]);
                    fields[i].setPreviousField(fields[63]);
                    break;
                case 43: // Intersection 2 First 1
                    fields[i].setNextField(fields[i - 1]);
                    fields[i].setPreviousField(fields[30]);
                    break;
                case 20: // Start Position 2
                    fields[i].setNextField(fields[1]);
                    fields[i].setPreviousField(fields[i - 1]);
                    break;
                case 21: // Start Position 2
                    fields[i].setNextField(fields[i + 1]);
                    fields[i].setPreviousField(fields[1]);
                    break;
                case 30: // Intersection 1
                    fields[i].setNextField(fields[31]);
                    fields[i].setOptionalNextField(fields[43]);
                    break;
                case 35: // Start Position 3
                    fields[i].setNextField(fields[2]);
                    fields[i].setPreviousField(fields[i - 1]);
                    break;
                case 36: // Start Position 3
                    fields[i].setNextField(fields[i + 1]);
                    fields[i].setPreviousField(fields[2]);
                    break;
                case 40: // Intersection 1 First 1
                    fields[i].setNextField(fields[44]);
                    fields[i].setPreviousField(fields[i - 1]);
                    break;
                case 53: // Start Position 4
                    fields[i].setNextField(fields[3]);
                    fields[i].setPreviousField(fields[i - 1]);
                    break;
                case 54: // Start Position 4
                    fields[i].setNextField(fields[i + 1]);
                    fields[i].setPreviousField(fields[3]);
                    break;
                case 63: // Intersection 2
                    fields[i].setNextField(fields[i + 1]);
                    fields[i].setOptionalNextField(fields[11]);
                    break;
                case 68: // Start Position 1
                    fields[i].setNextField(fields[0]);
                    fields[i].setPreviousField(fields[i - 1]);
                    break;
                default:
                    fields[i].setPreviousField(fields[i - 1]);
                    fields[i].setNextField(fields[i + 1]);
                    break;
            }
        }
    }
}
