package Engine;

import java.util.Queue;

public class Interpreter {

    private Queue<Simbolos.Terminais> tokens;
    private Simbolos.Terminais currentToken;

    public boolean analisar(Queue<Simbolos.Terminais> entrada) {
        this.tokens = entrada;
        this.nextToken();
        return ruleS() && this.currentToken == null; 
    }

    private void nextToken() {
        this.currentToken = tokens.poll(); 
    }

    private boolean checkToken(Simbolos.Terminais expected) {
        if (this.currentToken == expected) {
            nextToken();
            return true;
        }
        return false;
    }

    // Regra S
    private boolean ruleS() {
        if (ruleT() && ruleK()) {
            return true;
        }
        return false;
    }

    // Regra K
    private boolean ruleK() {
        if (checkToken(Simbolos.Terminais.SUM) || checkToken(Simbolos.Terminais.SUB)) {
            if (ruleT() && ruleK()) {
                return true;
            }
            return false;
        }
        return true;
    }

    // Regra T
    private boolean ruleT() {
        return ruleF() && ruleZ();
    }

    // Regra Z
    private boolean ruleZ() {
        if (checkToken(Simbolos.Terminais.MULT) || checkToken(Simbolos.Terminais.DIV)) {
            if (ruleF() && ruleZ()) {
                return true;
            }
            return false;
        }
        return true;
    }

    // Regra F
    private boolean ruleF() {
        if (checkToken(Simbolos.Terminais.ABR)) { 
            if (ruleS() && checkToken(Simbolos.Terminais.FEC)) { 
                return true;
            }
            return false; 
        } else if (checkToken(Simbolos.Terminais.SUB)) { 
            return ruleN();
        } else {
            return ruleN(); 
        }
    }

    // Regra N
    private boolean ruleN() {
        if (checkToken(Simbolos.Terminais.T1) || checkToken(Simbolos.Terminais.T2) || 
            checkToken(Simbolos.Terminais.T3) || checkToken(Simbolos.Terminais.T4) || 
            checkToken(Simbolos.Terminais.T5) || checkToken(Simbolos.Terminais.T6) || 
            checkToken(Simbolos.Terminais.T7) || checkToken(Simbolos.Terminais.T8) || 
            checkToken(Simbolos.Terminais.T9)) {
            return ruleD();
        }
        return false;
    }

    // Regra D
    private boolean ruleD() {
        if (checkToken(Simbolos.Terminais.T0) || checkToken(Simbolos.Terminais.T1) || 
            checkToken(Simbolos.Terminais.T2) || checkToken(Simbolos.Terminais.T3) || 
            checkToken(Simbolos.Terminais.T4) || checkToken(Simbolos.Terminais.T5) || 
            checkToken(Simbolos.Terminais.T6) || checkToken(Simbolos.Terminais.T7) || 
            checkToken(Simbolos.Terminais.T8) || checkToken(Simbolos.Terminais.T9)) {
            return ruleD(); 
        }
        return true;
    }
}