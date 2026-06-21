Decorator Pattern for File Storage Service
==========================================

Problem Statement
-----------------

You are building a file storage service like Google Drive or Dropbox. The service allows users to upload files, store them securely, and retrieve them when needed. You need to add more functionality to the service, such as encryption, compression, and virus scanning. The developers have implemented all this functionality in a single class, which is becoming difficult to maintain and extend.

Here is the [StorageManager](https://www.scaler.com/academy/mentee-dashboard/class/508684/assignment/problems/src/main/java/contest/StorageManager.java) class:

```  
public class StorageManager {      
        
        public void storeFile(byte[] fileData, String fileName) {          
            
            // Scan the data for viruses          
            boolean hasVirus = StorageUtils.scanForVirus(fileData);          
            if (hasVirus) {              
                throw new VirusDetectedException("Virus detected in file: " + fileName);          
            }          
            
            // Compress the data          
            byte[] compressedData = StorageUtils.compress(fileData);          
            
            // Store the data          
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
``` 

You can see that the StorageManager class is responsible for scanning files for viruses, compressing and decompressing data, and storing and retrieving files. This class is tightly coupled with the implementation details of these features, making it difficult to extend or modify the functionality.

For example, if you want to store some files without compressing them, how would you do it? Similarly, if you want to disable virus scanning for some files, how would you achieve that? The current implementation does not provide an easy way to add or remove features without modifying the existing code. Your task is to refactor this code using the Decorator pattern to make it more flexible and extensible.

Assignment
----------

Your task is to implement the Decorator pattern to enhance the file storage service. The Decorator pattern allows you to add additional functionality to objects dynamically at runtime without modifying their structure. By applying decorators to the core file storage logic, you can easily enhance its features with encryption, compression, virus scanning, and other capabilities.

### Task 1 - Implement the FileStorage Interface

You have been provided with a base class named StorageManager, which currently handles compression and virus scanning in a tightly coupled manner. Your first task is to extract a common interface for file storage operations. You need to complete the FileStorage interface by adding two methods:

*   Add a method storeFile that takes a String fileName and a byte\[\] content as arguments with no return value.

*   Add a method getFile that takes a String fileName as an argument and returns a byte\[\].


### Task 2 - Implement the RawFileStorage Class

Next, you need to implement the [RawFileStorage](https://www.scaler.com/academy/mentee-dashboard/class/508684/assignment/problems/src/main/java/contest/RawFileStorage.java)class, which is a concrete implementation of the FileStorage and simply stores and retrieves the raw file content. The tasks are as follows:

*   Implement the FileStorage interface to simply store and get the raw file content.

*   Use the methods StorageUtils.store(String, byte\[\]) and StorageUtils.read(String) to perform the actual storage and retrieval operations.


### Task 3 - Implement the BaseFileDecorator Class

Now, you need to implement the [BaseFileDecorator](https://www.scaler.com/academy/mentee-dashboard/class/508684/assignment/problems/src/main/java/contest/BaseFileDecorator.java) abstract class, which is the base class for all decorators. Each decorator should have the same methods as the product it decorates, i.e., storeFile and getFile. It also needs to call the next decorator in the chain and finally call the raw file storage. The tasks are as follows:

*   Inherit from the FileStorage interface.

*   Store a reference to the next layer of type FileStorage.


### Task 4 - Implement the CompressionDecorator and VirusScanningDecorator Classes

Finally, you need to implement the CompressionDecorator and VirusScanningDecorator classes, which are concrete decorators that add compression and virus scanning functionality to the file storage service. The tasks are as follows:

*   Implement the CompressionDecorator class to compress and decompress the file content. Use the StorageUtils.compress and StorageUtils.decompress methods for this purpose. Remember to call the next layer in the chain while reading and writing the file content.

*   Implement the VirusScanningDecorator class to scan the file content for viruses before storing and reading the file content. Use the StorageUtils.scanForVirus method for this purpose.


### Instructions

1.  Review the provided StorageManager class and the StorageUtils class to understand the existing file storage implementation.

2.  Complete the FileStorage interface by adding the storeFile() and getFile() methods.

3.  Implement the FileStorage interface in the RawFileStorage class to store and retrieve the raw file content.

4.  Complete the BaseFileDecorator abstract class by implementing the FileStorage interface and storing a reference to the next layer of type FileStorage.

5.  Create the CompressionDecorator class to add compression and decompression functionality to the file storage service.

6.  Create the VirusScanningDecorator class to add virus scanning functionality to the file storage service.