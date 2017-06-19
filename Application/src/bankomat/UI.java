package bankomat;

/**
 * Created by user on 07.06.2017.
 */
public class UI implements OnBankomatListener{

    public void startUI() {
        Bankomat b  = new Bankomat(new OnBankomatListener() {
            @Override
            public void onGetMoney(int sum) {

            }

            @Override
            public void onGetMoney(boolean isOk) {

            }
        });

        b.getMoney(100);
        b.putMoney(70);
    }

    @Override
    public void onGetMoney(int sum) {
        if (sum > 0) {
            System.out.println("SUccess");
        } else {
            System.out.println("fault");
        }
    }

    @Override
    public void onGetMoney(boolean isOk) {
        if (isOk) {
            System.out.println("SUccess");
        } else {
            System.out.println("fault");
        }
    }
}
