import com.saxonica.xqj.SaxonXQDataSource;
import demos.DemoXquery;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

public class XqueryEvaluator {
	
    // Deve ser criado um ficheir com a extensão: xqy, contendo a consulta
    public static void execute(String path, String filenameWithQuery) {
        try {
            InputStream inputStream = new FileInputStream(new File(path + query));
            XQDataSource ds = new SaxonXQDataSource();
            XQConnection conn = ds.getConnection();
            XQPreparedExpression exp = conn.prepareExpression(inputStream);
            XQResultSequence result = exp.executeQuery();

            while (result.next()) {
                System.out.println(result.getNode().getTextContent());
            }
        } catch (FileNotFoundException | XQException e) {
            Logger.getLogger(DemoXquery.class.getName()).log(Level.SEVERE, null, e);

        }
    }
}
