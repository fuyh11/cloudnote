package service.notebook;

import java.util.List;
import java.util.Map;

import service.exception.UserNotFoundException;

public interface NotebookService {

    List<Map<String, Object>> listNotebooks(String userId) throws UserNotFoundException;

}
