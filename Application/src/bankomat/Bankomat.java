package bankomat;

/**
 * Created by user on 07.06.2017.
 */
public class Bankomat {
    private int count20 = 10;
    private int count50 = 10;
    private int count100 = 10;

    private OnBankomatListener ui;

    public Bankomat(OnBankomatListener ui) {
        this.ui = ui;
    }

    public void getMoney(int sum){
        ui.onGetMoney(sum);
    }

    public void putMoney(int sum) {
        ui.onGetMoney(true);
    }

}
