package com.vsolv.appframework.http.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class GetJsonArgumentResolverTest {

    @Test
    @DisplayName("Test method with an annotation")
    public void supportsMethodWithAnnotationTest() {
        GetJsonArgumentResolver resolver = new GetJsonArgumentResolver();
        try {
            Method method = ControllerStub.class.getMethod("methodWithAnnotation", Object.class);
            MethodParameter methodParameter = new MethodParameter(method, 0);
            assertTrue(resolver.supportsParameter(methodParameter));
        } catch (NoSuchMethodException e) {
            fail("No such method in the test class");
        }
    }

    @Test
    @DisplayName("Test method without an annotation")
    public void supportsMethodWithoutAnnotationTest() {
        GetJsonArgumentResolver resolver = new GetJsonArgumentResolver();
        try {
            Method method = ControllerStub.class.getMethod("methodWithoutAnnotation", Object.class);
            MethodParameter methodParameter = new MethodParameter(method, 0);
            assertFalse(resolver.supportsParameter(methodParameter));
        } catch (NoSuchMethodException e) {
            fail("No such method in the test class");
        }
    }

}
