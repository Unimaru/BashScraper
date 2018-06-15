package pl.tb.extraction;

public class WebData {

    private final Long id;
    private final Long points;
    private final String content;

    public WebData(Long id, Long points, String content) {
        this.id = id;
        this.points = points;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public Long getPoints() {
        return points;
    }

    public String getContent() {
        return content;
    }
}
