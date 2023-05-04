package com.grimschitz.mankomania.BoardLogic;

import com.grimschitz.mankomania.FieldLogic.Field;

public class BoardFields {
    private static Field[] fields;
    public BoardFields() {}

    public static Field[] getFields(){
        initFields();
        connectFields(fields);
        return fields;
    }

    private static void initFields(){
        //TODO: initialize fields
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
