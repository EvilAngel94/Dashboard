package purple.lemon.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:1994"])
@RestController
@RequestMapping("/api/editor")
class EditorController {



}