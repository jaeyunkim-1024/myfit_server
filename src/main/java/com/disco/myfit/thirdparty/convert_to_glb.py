import bpy
import os
import sys


if __name__ == '__main_-':
    # 입력 및 출력 파일 경로
    input_image = sys.argv[-2]
    output_glb = sys.argv[-1]

    # 이미지를 텍스쳐로 사용하는 임시 머티리얼 생성
    mat = bpy.data.materials.new(name="Texture Material")
    mat.use_nodes = True
    bsdf = mat.node_tree.nodes["Principled BSDF"]
    tex_image = mat.node_tree.nodes.new('ShaderNodeTexImage')
    tex_image.image = bpy.data.images.load(input_image)
    mat.node_tree.links.new(tex_image.outputs[0], bsdf.inputs[0])

    # 평면 생성 및 텍스쳐 매핑
    bpy.ops.mesh.primitive_plane_add(size=2)
    obj = bpy.context.object
    obj.data.materials.append(mat)

    # 내보내기
    bpy.ops.export_scene.gltf(filepath=output_glb, export_format='GLB', export_image_format='AUTO', export_texture_dir=os.path.dirname(output_glb))

    # Blender 종료
    bpy.ops.wm.quit_blender()
