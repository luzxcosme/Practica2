import math
import tkinter as tk


class Punto:
    def _init_(self, x, y):
        self.x = x
        self.y = y

    def coordenadas_cartesianas(self):
        print(f"Los puntos del plano cartesiano son: ({self.x}, {self.y})")

    def coordenadas_polares(self):
        r = math.sqrt(self.x*2 + self.y*2)
        theta = math.atan2(self.y, self.x)
        print(f"Las coordenadas polares son: (r = {r}, θ = {theta})")

    def _str_(self):
        return f"({self.x}, {self.y})"


class Linea:
    def _init_(self, p1, p2):
        self.p1 = p1
        self.p2 = p2

    def _str_(self):
        return f"Línea desde el punto {self.p1} hasta el punto {self.p2}"

    def dibujar_linea(self, canvas):
        print(f"Dibujando una línea desde el punto {self.p1} hasta el punto {self.p2}")
        canvas.create_line(self.p1.x, self.p1.y, self.p2.x, self.p2.y, fill="blue")


class Circulo:
    def _init_(self, centro, radio):
        self.centro = centro
        self.radio = radio

    def _str_(self):
        return f"Círculo con centro en los puntos: {self.centro} y con radio {self.radio}"

    def dibujar_circulo(self, canvas):
        print(f"Dibujando un círculo con centro en los puntos {self.centro} y con radio {self.radio}")
        canvas.create_oval(
            self.centro.x - self.radio,
            self.centro.y - self.radio,
            self.centro.x + self.radio,
            self.centro.y + self.radio,
            outline="red"
        )


a = Punto(100, 100)
b = Punto(200, 200)


print("Primer punto")
a.coordenadas_cartesianas()
a.coordenadas_polares()

print("Segundo punto")
b.coordenadas_cartesianas()
b.coordenadas_polares()


root = tk.Tk()
root.title("Dibujar Línea y Círculo")
canvas = tk.Canvas(root, width=400, height=400)
canvas.pack()


print("Línea_")
l = Linea(a, b)
print(l)
l.dibujar_linea(canvas)


print("Círculo")
c = Circulo(a, 50)
print(c)
c.dibujar_circulo(canvas)

d = Circulo(b, 50)
print(d)
d.dibujar_circulo(canvas)


root.mainloop()
