package pl.tb.extraction;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebData webData = (WebData) o;
        return Objects.equals(id, webData.id) &&
                Objects.equals(points, webData.points) &&
                Objects.equals(content, webData.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, points, content);
    }
}
