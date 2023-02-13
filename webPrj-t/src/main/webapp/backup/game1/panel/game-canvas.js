function GameCanvas(){
    this.dom = document.querySelector(".game-canvas");        
    /** @type {CanvasRenderingContext2D} */
    this.ctx = this.dom.getContext("2d");
    this.boy = new Boy(100,100);

    this.dom.onclick = this.clickHandler.bind(this);
}
GameCanvas.prototype = {
    run:function(){
        // 60프레임으로 화면을 다시 그리는 코드        
        this.update();
        this.draw();        
    },
    update:function(){
    },
    draw:function(){
        this.boy.draw(this.ctx);        
    },
    // --- event handlers -----------------
    clickHandler:function(){
        this.boy.move(2);
        // 화면 지우기
        this.boy.draw(this.ctx);        
    }
};