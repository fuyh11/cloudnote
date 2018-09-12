package mapper;

import java.util.List;
import java.util.Map;

public interface NotebookMapper {

    List<Map<String, Object>> findNotebooksByUserId(String userId);

    int countNotebookById(String notebookId);

}
