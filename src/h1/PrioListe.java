package h1;

import java.util.ArrayList;

public class PrioListe {

    public ArrayList<Patient> myList;

    public PrioListe() {
        myList = new ArrayList<Patient>();
    }

    public void addPatient(Patient p) {
        if (myList.isEmpty()) {
            myList.add(p);
            return;
        }

        for (int i = 0; i < myList.size(); i++) {
            if (p.prio < myList.get(i).prio) {
                myList.add(i, p);
                return;
            }
        }
        myList.add(p);
    }

    public Patient getNextPatient() {
        if (myList.isEmpty()) {
            return null;
        }
        return myList.remove(0);
    }

    public int getPosition(Patient p) {
        return myList.indexOf(p);
    }
}