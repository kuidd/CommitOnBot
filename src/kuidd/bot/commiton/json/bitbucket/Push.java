package kuidd.bot.commiton.json.bitbucket;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Push {

@SerializedName("changes")
@Expose
private List<Change> changes = null;

public List<Change> getChanges() {
return changes;
}

public void setChanges(List<Change> changes) {
this.changes = changes;
}

}