package ohtu.intjoukkosovellus;

import java.util.HashSet;
import java.util.Set;

public class IntJoukko {

    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 
    private Set<Integer> jono;

    public IntJoukko() {
        this.jono = new HashSet<>();
    }
    
    public IntJoukko(int eka) {
        this.jono = new HashSet<>();
    }
    
    public IntJoukko(int eka, int toka) {
        this.jono = new HashSet<>();
    }

    public Set<Integer> getJono() {
        return jono;
    }

    public void setJono(Set<Integer> jono) {
        this.jono = jono;
    }
    
    public boolean lisaa(int luku) {
        return this.jono.add(luku);
//        if (alkioidenLkm == lukujono.length) {
//            int[] taulukkoOld = lukujono;
//                lukujono = new int[alkioidenLkm + kasvatuskoko];
//                kopioiTaulukko(taulukkoOld, lukujono);
//        }
//        if (!kuuluu(luku)) {
//            lukujono[alkioidenLkm] = luku;
//            alkioidenLkm++;
//            return true;
//        }
//        return false;
    }

    public boolean kuuluu(int luku) {
        return this.jono.contains(luku);
//        for (int i : lukujono) {
//            if (i == luku) {
//                return true;
//            }
//        }
//        return false;
    }

    public boolean poista(int luku) {
        return this.jono.remove(luku);
//        int kohta = -1;
//        int apu;
//        for (int i = 0; i < alkioidenLkm; i++) {
//            if (luku == lukujono[i]) {
//                kohta = i; //siis luku löytyy tuosta kohdasta :D
//                lukujono[i] = 0;
//                break;
//            }
//        }
//        if (kohta != -1) {
//            for (int j = kohta; j < alkioidenLkm - 1; j++) {
//                apu = lukujono[j];
//                lukujono[j] = lukujono[j + 1];
//                lukujono[j + 1] = apu;
//            }
//            alkioidenLkm--;
//            return true;
//        }
//
//        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);

    }

    public int getAlkioidenLkm() {
        return this.jono.size();
    }

    @Override
    public String toString() {
        String palautus = "{";
//        for (int i = 0; i < alkioidenLkm; i++) {
//            palautus += lukujono[i];
//            if (i != alkioidenLkm - 1) {
//                palautus += ", ";
//            }
//        }
        for (int i : jono) {
            palautus += i + ", ";
        }
        if (this.jono.size() > 0) {
            palautus = palautus.substring(0, palautus.lastIndexOf(","));
        }
        
        palautus += "}";
        return palautus;
    }

    public int[] toIntArray() {
        return this.jono.stream().mapToInt(Number::intValue).toArray();
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i : a.getJono()) {
            x.lisaa(i);
        }
        for (int i : b.getJono()) {
            x.lisaa(i);
        }
//        for (int i = 0; i < aTaulu.length; i++) {
//            x.lisaa(aTaulu[i]);
//        }
//        for (int i = 0; i < bTaulu.length; i++) {
//            x.lisaa(bTaulu[i]);
//        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        a.getJono().retainAll(b.getJono());
        for (int i : a.getJono()) {
            y.lisaa(i);
        }
//        for (int i = 0; i < aTaulu.length; i++) {
//            for (int j = 0; j < bTaulu.length; j++) {
//                if (aTaulu[i] == bTaulu[j]) {
//                    y.lisaa(bTaulu[j]);
//                }
//            }
//        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i : a.getJono()) {
            a.lisaa(i);
        }
        for (int i : b.getJono()) {
            z.poista(i);
        }
//        for (int i = 0; i < aTaulu.length; i++) {
//            z.lisaa(aTaulu[i]);
//        }
//        for (int i = 0; i < bTaulu.length; i++) {
//            z.poista(i);
//        }
        return z;
    }

}
