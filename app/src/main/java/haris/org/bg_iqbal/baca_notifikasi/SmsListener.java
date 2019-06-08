package haris.org.bg_iqbal.baca_notifikasi;

public interface SmsListener {
    public void messageReceived(String nomor, String messagetext);
}
