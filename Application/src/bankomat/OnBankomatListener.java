package bankomat;

/**
 * Created by user on 07.06.2017.
 */
public interface OnBankomatListener {

    public void onGetMoney(int sum);

    public void onGetMoney(boolean isOk);

}
