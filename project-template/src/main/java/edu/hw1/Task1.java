package edu.hw1;

public class Task1 {
    private Task1() {
    }

//    public static void main(String[] args) {
//        String movieLenStr = "01:13";
//        int lenSec = getMovieLenSec(movieLenStr);
//    }

    public static int getMovieLenSec(String movieLenStr) throws NumberFormatException {
        int minutes;
        int seconds;

        try {
            String[] lenSplit = movieLenStr.split(":");
            minutes = Integer.parseInt(lenSplit[0]);
            seconds = Integer.parseInt(lenSplit[1]);
        } catch (Exception ex) {
            throw new NumberFormatException(ex.getMessage());
        }

        if (seconds < 60 && seconds >= 0 && minutes >= 0) {
            int secPerMin = 60;
            return minutes * secPerMin + seconds;
        }

        return -1;
    }
}
