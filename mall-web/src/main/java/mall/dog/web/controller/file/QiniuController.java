package mall.dog.web.controller.file;

import mall.dog.entity.response.Entity;
import mall.dog.service.upload.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/8/30 mall.dog.web.controller.file
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@RestController
@RequestMapping("admin/file")
public class QiniuController {

	private final UploadService uploadService;

	@Autowired
	public QiniuController(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	@PostMapping("token")
	public Entity getToken() {
		return uploadService.generateToken();
	}

}
