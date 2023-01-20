package com.giri.springdata.filedata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.giri.springdata.filedata.entities.Image;
import com.giri.springdata.filedata.repos.ImageRepository;

@SpringBootTest
class FileDataApplicationTests {
	
	@Autowired
	ImageRepository imageRepo;

	@Test
	void testImageSave() throws IOException {
		Image image = new Image();
		image.setId(1L);
		image.setName("dummy.png");
		
		File file = new File("C://Users//GIRIDHARGOPAL//Pictures//dummy.png");
		byte fileContent[] = new byte[(int)file.length()];
		FileInputStream fs= new FileInputStream(file);
		fs.read(fileContent);
		image.setData(fileContent);
		imageRepo.save(image);
		fs.close();
		
	}
	
	@Test
	void testReadImage() {
		Image image = imageRepo.findById(1L).get();
		byte[] data = image.getData();
		File file = new File("C://Users//GIRIDHARGOPAL//Pictures//screenshots//"+image.getName());
		byte fileContent[] = new byte[(int)file.length()];
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
