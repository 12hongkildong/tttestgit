
function Boy(x, y) {
    this.x = x || 100;
    this.y = y || 100;

    this.ix = 1;
    this.iy = 2;

    // 이건 이제 우리가 손대는 것이 아님.
    this.sw = 106;
    this.sh = 148.25;
    this.sx = this.sw * this.ix; //sw*0, sw*1, sw*2
    this.sy = this.sh * this.iy;
}

Boy.prototype = {
    draw: function (ctx) {
        var img = new Image();
        img.src = "./image/boy.png";
        img.onload = function () {
            console.log(this.sw);

            ctx.drawImage(img,
                this.sx, this.sy, this.sw, this.sh,
                this.x, this.y, 106, 148.25);
        }.bind(this);
    },
    move: function (dir) {
        switch (dir) {
            case 1://북쪽
                this.y -= 10;
                break;
            case 2://동쪽
                this.x += 10;
                break;
            case 3://남쪽
                this.y += 10;
                break;
            case 4://서쪽
                this.x -= 10;
                break;
        }
    }
};