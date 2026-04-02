import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String url;
    private LocalDateTime fecha;
    private int contLiks;

    public Post(String url) {
        this.url = url;
        fecha = LocalDateTime.now();
        contLiks = 0;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getContLiks() {
        return contLiks;
    }

    public void setContLiks(int contLiks) {
        this.contLiks = contLiks;
    }


    public void like() {
        contLiks++;
    }

    @Override
    public String toString() {
        return  "url: " + url + " liks: " + contLiks + ", fecha= " +
                fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))+"\n";
    }


}
