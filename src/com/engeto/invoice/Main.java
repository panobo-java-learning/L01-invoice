package com.engeto.invoice;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // deklarace promennych:

        String item;    // String zacina velkym - je to objektovy DT (Datovy Typ)

        int quantity;   // int zacina malym pismenem - je to primitivni DT
                        // Pozn.: nema smysl pouzivat DT short misto int za ucelem uspory mista, protoze se
                        // stejne alokuji std. 4 byty a akorat se k tomu prida nejaka kontrola,
                        // ktera hlida, zda nebyl prekrocen rozsah... (ale nevim, jestli to vyhodi vyjimku...)

        Integer quantity2; // Objektovy DT - umoznuje operace nad tim konkretnim DT. Napr. pri praci s DB nabizi lepsi
                            // komfort pri prevadeni do DB. Primitivni DT budou lehce efektivnejsi na zpracovani.
                            // Pokud ale mam vyuziti pro tu pridanou hodnotu operaci nad danym DT, neni duvod objektove
                            // DT nepouzivat... Pri vykonu dnesnich pocitacu je to v podstate v poho.

                            // Existuji i jine duvody: Seznamy neumi pracovat s primitivnimi DT, proto
                            // musim pouzivat objektove DT

        double weight;  // double, stejne jako int jsou primitivni neobjektove DT, ktere v podstate oznacuji akorat
                        // rozsah alokovane pameti
        double totalWeight;

        BigDecimal PricePerPiece;   // !POZOR! U financi se vyhybat DT double, nebo float, protoze se vzdy prevadi do dvojkove
                                // soustavy, cimz dochazi k neocekavanym zkreslenim. U prevodu mohou vznikat periodicka
                                // cisla a nasledne na nejakem (napr. dvacatem)
                                // miste dochazi k zaokrouhlovaci chybe!!!!
                                // Vsude, kde chci mit presnost v desetinnych cislech, pouzivam DT decimal,
                                // nebo bigDecimal. Tam se vse uklada primo v tech desetinnych mistech desitkove soustavy.
        BigDecimal totalPrice, transportationPrice, totalPriceTransportation;

        LocalDate dateOfIssue = LocalDate.of(2022, 4, 7);     // Existuje i trida Date, ale ta je starsi, takze pokud to neni nutne, je lepsi pouzivat
                            // novejsi implementaci DT pro datum LocalDate. Tuto tridu je ale zapotrebi naimportovat rucne!
                            // Pokud pouziju LocalDate pres InteliSense (tj. necham si to pres klavesu Tab doplnit),
                            // tak se mi to automaticky naimportuje!
                            // Pro pripad pouziti IntelliJ: kdyz to sviti cervene, tak lze pouzit Alt+Enter a nechat
                            // si tu tridu automaticky naimportovat

        boolean is_discounted;

        // definice promennych:
        item = "Trekove boty Sedmimilovky";
        quantity = 3;
        weight = 0.45;
        PricePerPiece = BigDecimal.valueOf(1800);

        // zmena hodnoty
        quantity = 2;
        quantity = quantity + 5;
        quantity += 5;

        is_discounted = true;

        // pouziti promenne
        System.out.println(quantity);
        System.out.println("Pocet paru je: " + quantity + ".");
        System.out.println("Hmotnost jednoho paru je " + weight + " kg.");
        System.out.println("Cena jednoho paru je " + PricePerPiece + " Kc.");

        totalWeight = quantity * weight;
        System.out.println("Celkova hmothnost zasilky je " + totalWeight + " kg.");

        totalPrice = BigDecimal.valueOf(quantity).multiply(PricePerPiece);
        System.out.println("Celkova cena zasilky je " + totalPrice + "Kc.");

        transportationPrice = BigDecimal.valueOf(45);
        totalPriceTransportation = totalPrice.add(transportationPrice);
        System.out.println("Celkova cena zasilky s dopravou je " + totalPriceTransportation + "Kc.");
    }
}
