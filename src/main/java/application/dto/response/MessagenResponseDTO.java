package application.dto.response;

import application.dto.response.MessagenResponseDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessagenResponseDTO {

	private String message;

}
