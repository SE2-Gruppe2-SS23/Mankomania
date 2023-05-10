package com.grimschitz.mankomania.ShareLogic;

public enum Share {
    HARD_STEEL_PLC{
        @Override
        public String getName(){ return "HardSteel PLC";}
    },
    SHORT_CIRCUIT_PLC{
        @Override
        public String getName(){ return "ShortCircuit PLC";}
    },
    DRY_OIL_PLC{
        @Override
        public String getName(){ return "DryOil PLC";}
    };

    public abstract String getName();
}
