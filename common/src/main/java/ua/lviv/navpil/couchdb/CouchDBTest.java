package ua.lviv.navpil.couchdb;

import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;

import java.net.MalformedURLException;
import java.util.List;

public class CouchDBTest {

    public static void main(String[] args) throws MalformedURLException {
        HttpClient httpClient = new StdHttpClient.Builder().url("http://localhost:5984").build();

        StdCouchDbInstance instance = new StdCouchDbInstance(httpClient);
        StdCouchDbConnector db = new StdCouchDbConnector("hello-world", instance);

        List<String> allDocIds = db.getAllDocIds();
        for (String allDocId : allDocIds) {
            System.out.println("Doc id is " + allDocId);
        }

        ViewQuery query = new ViewQuery();
        ViewQuery viewQuery = query.designDocId("_design/myDesignDoc").viewName("prices");
        simpleView(db, viewQuery);
        complicatedView(db, viewQuery);

    }

    private static void complicatedView(StdCouchDbConnector db, ViewQuery viewQuery) {
        List<FruitView> rows = db.queryView(viewQuery, FruitView.class);

        for (FruitView row : rows) {
            System.out.println(row);
        }
    }

    private static void simpleView(StdCouchDbConnector db, ViewQuery viewQuery) {
        ViewResult rows = db.queryView(viewQuery);

        List<ViewResult.Row> rows1 = rows.getRows();
        for (ViewResult.Row row : rows1) {

            System.out.println(row);
        }
    }

    private static class FruitView {

        private final String value;


        private FruitView(String value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "FruitView{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
