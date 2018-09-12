package service.notebook.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.NotebookMapper;
import mapper.UserMapper;
import service.exception.UserNotFoundException;
import service.notebook.NotebookService;
import service.user.dataobject.UserDao;

@Service("notebookService")
public class NotebookServiceImpl implements NotebookService {

    @Resource
    private NotebookMapper notebookMapper;

    @Resource
    private UserMapper userDao;

    public List<Map<String, Object>> listNotebooks(String userId) throws UserNotFoundException {
        if (userId == null || userId.trim().isEmpty()) {
            throw new UserNotFoundException("ID不能空");
        }
        UserDao user = userDao.findUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }
        return notebookMapper.findNotebooksByUserId(userId);
    }

}

