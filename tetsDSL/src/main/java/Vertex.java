/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2019-02-14 下午2:22
 */
public class Vertex implements Comparable<Vertex> {
    private String label;

    public Vertex(String label) {
        this.label = label.toUpperCase();
    }

    @Override
    public int compareTo(Vertex o) {
        return (this.getLabel().compareTo(o.getLabel()));
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}