import { Dialog } from "@headlessui/react";

const MyDialog = ({ handleSubmit, isOpen, setIsOpen, children, title }) => {
  return (
    <Dialog open={isOpen} onClose={() => setIsOpen(false)}>
      <Dialog.Panel>
        <Dialog.Title>{title}</Dialog.Title>
        <Dialog.Description>{children}</Dialog.Description>
        <button onClick={() => setIsOpen(false)}>Cancel</button>
        <button onClick={handleSubmit}>Deactivate</button>
      </Dialog.Panel>
    </Dialog>
  );
};
export default MyDialog;
