package h2;

import java.util.ArrayList;

public class Bus {

    public ArrayList<Passenger> passengers;

    public Bus() {
        passengers = new ArrayList<Passenger>();
    }

    public void enterBus(Passenger p) {
        passengers.add(p);
    }

    private void exitBus() {
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).visited == passengers.get(i).planned) {
                passengers.remove(i);
                i--;
            }
        }
    }

    public void nextStop(Passenger[] boarding) {
        for (Passenger p : passengers) {
            p.visited++;
        }

        exitBus();

        if (boarding != null) {
            for (Passenger p : boarding) {
                passengers.add(p);
            }
        }
    }

    public void nextStop() {
        nextStop(null);
    }

    public ArrayList<Passenger> findPassengersWithoutTickets() {
        ArrayList<Passenger> removed = new ArrayList<Passenger>();

        for (int i = 0; i < passengers.size(); i++) {
            if (!passengers.get(i).ticket) {
                removed.add(passengers.get(i));
                passengers.remove(i);
                i--;
            }
        }
        return removed;
    }

    public void transferPassengers(Bus otherBus, String[] passengerNames) {
        for (int i = 0; i < passengers.size(); i++) {
            for (String name : passengerNames) {
                if (passengers.get(i).name.equals(name)) {
                    otherBus.enterBus(passengers.get(i));
                    passengers.remove(i);
                    i--;
                    break;
                }
            }
        }
    }
}