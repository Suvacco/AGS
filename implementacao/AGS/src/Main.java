import models.*;
import models.user.instances.*;
import system.AGS;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static AGS ags = new AGS();

    public static void main(String[] args) {

        ags.loginMenu();

        ags.actionMenu();
    }
}