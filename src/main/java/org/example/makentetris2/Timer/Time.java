
package org.example.makentetris2.Timer;
public class Time {
    private int minute;
    private int second;

    // Konstruktor für die Klasse Time
    public Time(int minute, int second) {
        this.minute = minute;
        this.second = second;
    }

    // Getter für die Minuten
    public String getCurrentTime() {
        return String.format("%02d:%02d", minute, second);
    }

    // Setter für die Minuten
    public void oneSecondPassed() {
        if (second == 0) {
            if (minute == 0) {
                return; // Stoppe die Zeit, wenn sie abgelaufen ist
            }
            minute--;
            second = 59; // Setze Sekunden auf 59, wenn Minuten reduziert werden
        } else {
            second--;
        }
    }

    // Methode, um die Zeit zu überprüfen
    public boolean isTimeUp() {
        return minute == 0 && second == 0;
    }
}