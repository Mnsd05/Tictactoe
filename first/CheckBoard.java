import java.util.ArrayList;

public class CheckBoard {
    ArrayList<Integer> check = new ArrayList<Integer>();
    CheckBoard () {
        for (int i = 0; i < 9; i++) {
            check.add(0);
          }
    }
    public boolean checkWin() {
        if (check.get(0) != 0 && check.get(0) == check.get(1) && check.get(1) == check.get(2)) {
            return true;
        }else if (check.get(3) != 0 && check.get(3) == check.get(4) && check.get(4) == check.get(5)) {
            return true;
        }else if (check.get(6) != 0 && check.get(6) == check.get(7) && check.get(7) == check.get(8)) {
            return true;
        }else if (check.get(0) != 0 && check.get(0) == check.get(3) && check.get(3) == check.get(6)) {
            return true;
        }else if (check.get(1) != 0 && check.get(1) == check.get(4) && check.get(4) == check.get(7)) {
            return true;
        }else if (check.get(2) != 0 && check.get(2) == check.get(5) && check.get(5) == check.get(8)) {
            return true;
        }else if (check.get(0) != 0 && check.get(0) == check.get(4) && check.get(4) == check.get(8)) {
            return true;
        }else if (check.get(2) != 0 && check.get(2) == check.get(4) && check.get(4) == check.get(6)) {
            return true;
        }
        return false;
    }
}
