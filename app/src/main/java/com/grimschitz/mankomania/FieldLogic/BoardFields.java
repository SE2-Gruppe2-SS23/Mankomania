package com.grimschitz.mankomania.FieldLogic;

public class BoardFields {

    public BoardFields(){}

    public static Field[] getFields(){
        Field[] fields = initFields();
        connectFields(fields);
        return fields;
    }
    public static Field[] initFields(){
        //TODO: set the list of fields that will be used
        return null;
    }

    public static void connectFields(Field[] fields){
        //TODO: connect all fields
    }


}
