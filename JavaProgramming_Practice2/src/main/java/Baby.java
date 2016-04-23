/**
 * Created by Alexandr Abashkin on 3/14/2016.
 */
public class Baby {
    int rank;
    String maleName;
    String femaleName;

    public Baby(int rank, String maleName, String femaleName) {
        this.rank = rank;
        this.maleName = maleName;
        this.femaleName = femaleName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getMaleName() {
        return maleName;
    }

    public void setMaleName(String maleName) {
        this.maleName = maleName;
    }

    public String getFemaleName() {
        return femaleName;
    }

    public void setFemaleName(String femaleName) {
        this.femaleName = femaleName;
    }

    @Override
    public String toString() {
        return "Baby{" +
                "rank=" + rank +
                ", maleName='" + maleName + '\'' +
                ", femaleName='" + femaleName + '\'' +
                '}';
    }
}
