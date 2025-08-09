package ejercicio2;

import java.util.ArrayList;

public class Intervalo{
    private StartYear inicio;
    private EndYear fin;

    public Intervalo(StartYear inicio, EndYear fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getInicio() {
        return inicio.startYear;
    }

    public int getFin() {
        return fin.endYear;
    }

    public int findYearWithMostRomanCharacters(){
        int maxRomanCharacters = 0;
        ArrayList<String> romanYears = new ArrayList<>();
        ArrayList<String> romanNumbers = new ArrayList<>();
        for (int i=1; i<=2765; i++)
        {
            String romanYear = RomanConverter.toRoman(i);
            romanYears.add(romanYear);
        }
        if (inicio.isBC) {
            if (fin.isBC) {
                for (int i = 753-inicio.startYear; i <= 753-fin.endYear; i++) {
                    romanNumbers.add(romanYears.get(i));
                }
            }else if (!fin.isBC) {
                for (int i = 753-inicio.startYear; i <= 753+fin.endYear-1; i++) {
                    romanNumbers.add(romanYears.get(i));
                }
            }else{
                throw new IllegalArgumentException("Error con los tipos de años.");
            }
        }else if (!inicio.isBC) {
            for(int i = 753+inicio.startYear-1; i <= 753+fin.endYear-1; i++){
                romanNumbers.add(romanYears.get(i));

            }
        }else {
            throw new IllegalArgumentException("Error con los tipos de años.");
        }
        for (String string : romanNumbers) {
            if (string.length() > maxRomanCharacters) {
                maxRomanCharacters = string.length();
            }
        }
        return maxRomanCharacters;
    }

}