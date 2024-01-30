package ex00.service;

import ex00.util.PathUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileServiceImpl implements FileService {
    private static Map<String, String> signatureOfFilesMap;
    private static FileService fileService;

    private FileServiceImpl() {
    }

    public static FileService getInstance() {
        if (fileService == null) {
            fileService = new FileServiceImpl();
            signatureOfFilesMap = collectMap();
        }
        return fileService;
    }

    @Override
    public void writeTypeOfFile(String path) {
        try (FileOutputStream fos = new FileOutputStream(PathUtil.getPathToResult())) {
            String signatureType = getFileSignature(path);
            String type = signatureOfFilesMap.get(signatureType);
            if (type != null) {
                fos.write(type.getBytes(StandardCharsets.UTF_8));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getFileSignature(String path) {
        try (FileInputStream fis = new FileInputStream(path)) {
            byte[] bytes = new byte[8];
            if (fis.read(bytes) != bytes.length) {
                throw new IOException("Unable to read the file signature");
            }
            return toHex(bytes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        for (int i = 2; i < sb.toString().length(); i += 3) {
            sb.insert(i, " ");
        }
        return sb.toString().toUpperCase().trim();
    }

    private static Map<String, String> collectMap() {
        Map<String, String> res = new HashMap<>();
        for (String line : getLines(PathUtil.getPathToSignal())) {
            String[] sepLines = line.split(",");
            res.put(sepLines[1].trim(), sepLines[0].trim());
        }
        return res;
    }

    private static List<String> getLines(String path) {
        List<String> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                res.add(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        return res;
    }

}
