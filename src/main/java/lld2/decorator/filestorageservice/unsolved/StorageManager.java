package lld2.decorator.filestorageservice.unsolved;


import lld2.decorator.filestorageservice.unsolved.utils.StorageUtils;
import lld2.decorator.filestorageservice.unsolved.utils.VirusDetectedException;

public class StorageManager {

    public void storeFile(byte[] fileData, String fileName) {
        // Scan the data for viruses
        boolean hasVirus = StorageUtils.scanForVirus(fileData);
        if (hasVirus) {
            throw new VirusDetectedException("Virus detected in file: " + fileName);
        }

        // Compress the data
        byte[] compressedData = StorageUtils.compress(fileData);

        // Store the data`
        StorageUtils.store(fileName, compressedData);

    }

    public byte[] getFile(String fileName) {

        byte[] compressedData = StorageUtils.read(fileName);
        if (compressedData == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }

        // Decompress the data
        byte[] data = StorageUtils.decompress(compressedData);

        // Scan the data for viruses
        boolean hasVirus = StorageUtils.scanForVirus(data);
        if (hasVirus) {
            throw new VirusDetectedException("Virus detected in file: " + fileName);
        }

        return data;
    }
}
