import java.io.*;

/**
 * Created by Abashkin Aleksandr on 22.03.2016.
 */
public class SerializableClassUtils {
    public static void serializableMethod(Group myGroup,File fileGroup){
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileGroup)))) {

            oos.writeObject(myGroup);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try ( ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileGroup)))){
            Group readGroup = (Group)ois.readObject();
            System.out.println(readGroup);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
