package com.exemple.ff;


import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.CLinker.*;
import jdk.incubator.foreign.SymbolLookup;
import java.lang.invoke.*;
import jdk.incubator.foreign.*;

public class ForeignFunctionsApplication {
    static CLinker LINKER = CLinker.systemCLinker();

    private static final SymbolLookup LOADER = SymbolLookup.loaderLookup();
    private static final SymbolLookup SYSTEM = CLinker.systemLookup();

    public static void main(String[] args) {
        System.out.println("Hello foreign-functions!");


    }
}
