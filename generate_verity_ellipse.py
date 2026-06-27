from PIL import Image, ImageDraw

img = Image.new('RGBA', (32, 32), (0, 0, 0, 0))
draw = ImageDraw.Draw(img)

draw.ellipse([0, 0, 31, 31], fill=(255, 255, 0, 255))

pixels = img.load()
cx, cy = 16, 16
eye_y = 11
eye_sep = 6

pixels[cx - eye_sep, eye_y] = (0, 0, 0, 255)
pixels[cx + eye_sep, eye_y] = (0, 0, 0, 255)

mouth_y = 19
pixels[cx - 3, mouth_y] = (0, 0, 0, 255)
pixels[cx - 2, mouth_y + 1] = (0, 0, 0, 255)
pixels[cx - 1, mouth_y + 2] = (0, 0, 0, 255)
pixels[cx, mouth_y + 2] = (0, 0, 0, 255)
pixels[cx + 1, mouth_y + 2] = (0, 0, 0, 255)
pixels[cx + 2, mouth_y + 1] = (0, 0, 0, 255)
pixels[cx + 3, mouth_y] = (0, 0, 0, 255)

img.save('verity_ellipse.png')
print("verity_ellipse.png created.")
