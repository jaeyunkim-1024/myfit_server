package com.disco.myfit.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GlbUtil {
    /// imagePath : 이미지 파일 경로 => 이미 일단 Png
    /// outputGlbPath : glb 저장 경로 => 확장자 glb
    public static void generate(String imagePath, String outputGlbPath) {
        try {
            // 외부 명령행 도구 호출
            ProcessBuilder pb = new ProcessBuilder("blender", "--background", "--python", "convert_to_glb.py", "--", imagePath, outputGlbPath);
            Process process = pb.start();

            // 도구 실행 후 출력 처리
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor(); // 프로세스 완료 기다림
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
