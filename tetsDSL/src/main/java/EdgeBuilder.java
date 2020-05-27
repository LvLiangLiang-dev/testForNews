/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2019-02-14 下午2:23
 */
public class EdgeBuilder {

    Edge edge;

    //Keep a back reference to the Graph Builder.
    GraphBuilder gBuilder;

    public EdgeBuilder(GraphBuilder gBuilder) {
        this.gBuilder = gBuilder;
        edge = new Edge();
    }

    public EdgeBuilder from(String lbl){
        Vertex v = new Vertex(lbl);
        edge.setFromVertex(v);
        gBuilder.getGraph().addVertice(v);
        return this;
    }
    public EdgeBuilder to(String lbl){
        Vertex v = new Vertex(lbl);
        edge.setToVertex(v);
        gBuilder.getGraph().addVertice(v);
        return this;
    }

    public GraphBuilder weight(Double d){
        edge.setWeight(d);
        return gBuilder;
    }

}