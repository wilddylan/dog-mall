package mall.dog.service.upload;

import com.qiniu.util.Auth;
import mall.dog.entity.response.Entity;
import org.springframework.stereotype.Service;

/**
 * 2018/8/30 mall.dog.service.upload
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Service
public class UploadService {

	public Entity generateToken() {
		String accessKey = "5GKJOBnD5zpdQfVsZoPOO4azgxGvpN3psjI29Ewa";
		String secretKey = "UnaAzD_GabP0SzKXebiR9pCif8ToZ6JI7mL26B_A";
		String bucket = "database";
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		return Entity.Success(upToken);
	}

}
