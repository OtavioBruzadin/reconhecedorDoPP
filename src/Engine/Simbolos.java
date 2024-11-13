package Engine;

import java.util.ArrayList;
import java.util.List;

public class Simbolos {

    public enum NaoTerminais {
        I,S,T,K,Z,D,F,N;
    }

    public enum Terminais {
        SUM, SUB, MULT, DIV, ABR, FEC, T0, T1, T2, T3, T4, T5, T6, T7, T8, T9;
    }

    private NaoTerminais valor;
    private List<String> regras;

    private Simbolos(NaoTerminais valor, List<String> regras) {
        this.valor = valor;
        this.regras = regras;
    }

    public NaoTerminais getValor() {
        return valor;
    }

    public List<String> getRegras() {
        return regras;
    }

    public static Terminais getTerminalFromString(char symbol) {
        if(symbol == '+') return Terminais.SUM;
        if(symbol == '-') return Terminais.SUB;
        if(symbol == '*') return Terminais.MULT;
        if(symbol == '/') return Terminais.DIV;
        if(symbol == '(') return Terminais.ABR;
        if(symbol == ')') return Terminais.FEC;
        if(symbol == '0') return Terminais.T0;
        if(symbol == '1') return Terminais.T1;
        if(symbol == '2') return Terminais.T2;
        if(symbol == '3') return Terminais.T3;
        if(symbol == '4') return Terminais.T4;
        if(symbol == '5') return Terminais.T5;
        if(symbol == '6') return Terminais.T6;
        if(symbol == '7') return Terminais.T7;
        if(symbol == '8') return Terminais.T8;
        if(symbol == '9') return Terminais.T9;

        return null;
    }

    public static Character getStringFromTerminal(Terminais terminal) {
        if(terminal == Terminais.SUM) return '+';
        if(terminal == Terminais.SUB) return '-';
        if(terminal == Terminais.MULT) return '*';
        if(terminal == Terminais.DIV) return '/';
        if(terminal == Terminais.ABR) return '(';
        if(terminal == Terminais.FEC) return ')';
        if(terminal == Terminais.T0) return '0';
        if(terminal == Terminais.T1) return '1';
        if(terminal == Terminais.T2) return '2';
        if(terminal == Terminais.T3) return '3';
        if(terminal == Terminais.T4) return '4';
        if(terminal == Terminais.T5) return '5';
        if(terminal == Terminais.T6) return '6';
        if(terminal == Terminais.T7) return '7';
        if(terminal == Terminais.T8) return '8';
        if(terminal == Terminais.T9) return '9';

        return null;
    }

    public List<Simbolos> setNaoTerminais() {
        List<Simbolos> naoTerminais = new ArrayList<>();

        naoTerminais.add(new Simbolos(NaoTerminais.I, (new ArrayList<>(List.of("I")))));
        naoTerminais.add(new Simbolos(NaoTerminais.S, (new ArrayList<>(List.of("TK")))));
        naoTerminais.add(new Simbolos(NaoTerminais.K, (new ArrayList<>(List.of("+TK", "-TK", "e")))));
        naoTerminais.add(new Simbolos(NaoTerminais.T, (new ArrayList<>(List.of("FZ")))));
        naoTerminais.add(new Simbolos(NaoTerminais.Z, (new ArrayList<>(List.of("*FZ", "/FZ", "e")))));
        naoTerminais.add(new Simbolos(NaoTerminais.F, (new ArrayList<>(List.of("(S)", "N", "-N")))));
        naoTerminais.add(new Simbolos(NaoTerminais.N, (new ArrayList<>(List.of("1D", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D")))));
        naoTerminais.add(new Simbolos(NaoTerminais.D, (new ArrayList<>(List.of("0D", "1D", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "e")))));

        return naoTerminais;
    }
}
