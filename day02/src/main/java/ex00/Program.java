package ex00;

import ex00.service.FileService;
import ex00.service.FileServiceImpl;
import ex00.util.PathUtil;

public class Program {
    public static void main(String[] args) {
        FileService fileService = FileServiceImpl.getInstance();
        fileService.writeTypeOfFile(PathUtil.getPathToPng());
    }
}
