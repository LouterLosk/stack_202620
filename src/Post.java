import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String url;
    private LocalDateTime fecha;

    public Post(String url) {
        this.url = url;
        fecha = LocalDateTime.now();
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

    @Override
    public String toString() {
        return  "url: " + url + ", fecha= " +
                fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))+"\n";
    }
}
