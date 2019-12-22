package com.travel.vision.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    @Bean
    public Docket CMS() {
        return baseDocket("Travel Vision API","","CMS");
    }
    public Docket Mobile() {
        return baseDocket("Travel Vision API","","Mobile");
    }
    private Docket baseDocket(String title, String description, String groupName){

        Parameter jwtTokenHeader = new ParameterBuilder()
                .name("Authorization")
                .description("'Bearer <token>'")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();

        ResponseMessage badRequest             = responseMessage(400, "Bad Request\n"+
                "Error Code:153    Error Message: 'Missing required fields or has not been well formed'\n"+
                "Error Code:158    Error Message: 'Email address {0} has already been verified.'\n"+
                "Error Code:153    Error Message: 'Password not compliant to the password policy'\n"+
                "Error Code:157    Error Message: 'This {0} has already been added to this {1}.'\n"+
                "Error Code:159    Error Message: 'The email address '{0}' does not match our records.'\n"+
                "Error Code:160    Error Message: 'This facebook account already exist'\n"+
                "Error Code:161    Error Message: 'This facebook account does not exist'\n"+
                "Error Code:162    Error Message: 'This account does not have a password'\n"+
                "Error Code:163    Error Message: 'Facebook token has expired or is invalid'\n"+
                "Error Code:164    Error Message: 'You cannot sign up without an email address'\n"+
                "Error Code:165    Error Message: 'Password cannot be the same as old password'\n"+
                "Error Code:100    Error Message: 'Can be any message'\n"
        );
        ResponseMessage unauthorized           = responseMessage(401, "Unauthorized Access\n\n" +
                "Error Code:151    Error Message: 'Your Account Has Been Locked Temporarily'\n" +
                "Error Code:152    Error Message: 'This {0} already exist'\n" +
                "Error Code:153    Error Message: 'No User Found'\n" +
                "Error Code:153    Error Message: 'Bad Username or Password'\n" +
                "Error Code:154    Error Message: 'Email Has Not Verified'\n" +
                "Error Code:100    Error Message: 'Can be any message'\n" +
                "");
        ResponseMessage forbidden              = responseMessage(403, "Forbidden Request\n"+
                "Error Code:100    Error Message: 'Can be any message'\n"
        );
        ResponseMessage notFound               = responseMessage(404, "Not Found\n"+
                "Error Code:100    Error Message: 'Can be any message'\n"
        );
        ResponseMessage conflict               = responseMessage(409, "Conflict\n"+
                "Error Code:100    Error Message: 'Can be any message'\n"
        );
        ResponseMessage unProcessableRequest   = responseMessage(422, "Un-processable Entity\n"+
                "Error Code:100    Error Message: 'Can be any message'\n"
        );
        ResponseMessage serverError            = responseMessage(500, "Server Error\n"+
                "Error Code:100    Error Message: 'Can be any message'\n"
        );
        Docket docket;
        if(groupName.equals("CMS")){
            docket = new Docket(DocumentationType.SWAGGER_2)
                    .groupName(groupName)
                    .apiInfo(apiInfo(title,description))
                    .select().paths(PathSelectors.regex("/admin/.*"))
                    .build()
                    .globalOperationParameters(List.of(jwtTokenHeader))
                    .useDefaultResponseMessages(false);
        } else {
            docket = new Docket(DocumentationType.SWAGGER_2)
                    .groupName(groupName)
                    .apiInfo(apiInfo(title, description))
                    .select().paths(PathSelectors.regex("/api/.*"))
                    .build()
                    .globalOperationParameters(List.of(jwtTokenHeader))
                    .useDefaultResponseMessages(false);
        }
        docket.directModelSubstitute(Locale.class, String.class);
        docket.genericModelSubstitutes(Optional.class);
        docket.globalResponseMessage(RequestMethod.GET,    List.of(badRequest, unauthorized, forbidden, notFound, serverError));
        docket.globalResponseMessage(RequestMethod.POST,   List.of(badRequest, unauthorized, forbidden, notFound, conflict, unProcessableRequest, serverError));
        docket.globalResponseMessage(RequestMethod.PATCH,  List.of(badRequest, unauthorized, forbidden, notFound, conflict, unProcessableRequest, serverError));
        docket.globalResponseMessage(RequestMethod.DELETE, List.of(badRequest, unauthorized, forbidden, notFound, conflict, serverError));
        return docket;
    }

    private ResponseMessage responseMessage(int code, String message) {
        return new ResponseMessageBuilder().code(code).message(message).build();
    }

    private ApiInfo apiInfo(String title,String description) {
        return new ApiInfo(
                title,
                description,
                "1.0",
                "",
                new Contact("Phillip Sylvain", "", "psylvain324@gmail.com"),
                "",
                "",
                List.of());
    }
}
